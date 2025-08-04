import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomService } from '../../core/service/room.service';
import { WebsocketService } from '../../core/service/websocket.service';

@Component({
  selector: 'app-join',
  imports: [CommonModule, FormsModule],
  templateUrl: './join.component.html',
  styleUrl: './join.component.css'
})
export class JoinComponent {

  private _hasRoom: boolean = false;

  constructor(
    private websocketService: WebsocketService,
    private roomService: RoomService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this._hasRoom = params['hasRoom'] === 'true';
      console.log('[Join] Has room:', this._hasRoom);
    });
  }

  public get hasRoom(): boolean {
    return this._hasRoom;
  }

  public joinRoom(form: any) {
    const formValue = form.value;
    
    this.createRoom(formValue);

    this.connectWebsocket(formValue.username);

    this.router.navigate(['/room']);
  }

  private createRoom(formValue: any): void {
    const payload = {
      roomName: formValue.roomName as string,
      estimateValue: formValue.estimateValue as string
    };

    if(!this._hasRoom) {
      this.roomService.create(payload).subscribe({
        next: (response) => console.log('Room created successfully:', response),
        error: (error) => console.error('Error creating room:', error)
      });
    }
  }

  private connectWebsocket(username: string): void {
    this.websocketService.connect(username);
  }
}
