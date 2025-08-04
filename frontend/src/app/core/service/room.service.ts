import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private httpClient: HttpClient) {}

  public hasRoom() {
    return this.httpClient.get<boolean>('http://localhost:8080/api/v1/room');
  }

  public create(payload: { roomName: string, estimateValue: string }) {
    return this.httpClient.post<boolean>('http://localhost:8080/api/v1/room', payload);
  }

}
