import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from '../../core/service/room.service';

@Component({
  selector: 'app-join',
  imports: [CommonModule, FormsModule],
  templateUrl: './join.component.html',
  styleUrl: './join.component.css'
})
export class JoinComponent {

  private _hasRoom: boolean = false;

  constructor(private roomService: RoomService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this._hasRoom = params['hasRoom'] === true;
      console.log('[Join] Has room:', this._hasRoom);
    });
  }

  public get hasRoom(): boolean {
    return this._hasRoom;
  }

  public joinRoom(form: any) {
    console.log(form.value);
    const payload = {
      roomName: form.value.roomName as string,
      estimateValue: form.value.estimateValue as string
    };

    this.roomService.create(payload).subscribe({
      next: (response) => console.log('Room created successfully:', response),
      error: (error) => console.error('Error creating room:', error)
    });
  }

}
