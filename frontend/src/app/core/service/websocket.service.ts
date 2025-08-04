import { Injectable } from '@angular/core';
import { Client, Message } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  private client: Client = new Client();
  private _users: { id: string; name: string }[] = [];

  get users(): { id: string; name: string }[] {
    return this._users;
  }

  connect(username: string) {
    this.client = new Client({
      brokerURL: undefined, // usamos SockJS
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
      reconnectDelay: 5000,
      connectHeaders: {
        username: username
      },
      onConnect: () => {
        console.log('Conectado!');

        this.client.subscribe('/topic/allUsers', (message: Message) => {
          console.log('[All Users] Mensagem recebida: ', message.body);
          this._users = JSON.parse(message.body);
        });

        this.getUsers();
      }
    });

    this.client.activate();
  }

  vote(msg: { sender: string; content: { userId: string, voteValue: number } }) {
    this.client.publish({ destination: '/app/users/vote', body: JSON.stringify(msg) });
  }

  private getUsers() {
    this.client.publish({ destination: '/app/users/getUsers' });
  }

}
