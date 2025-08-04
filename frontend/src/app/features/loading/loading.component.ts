import { Component } from '@angular/core';
import { RoomService } from '../../core/service/room.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-loading',
  imports: [RouterModule],
  templateUrl: './loading.component.html',
  styleUrl: './loading.component.css'
})
export class LoadingComponent {

  constructor(private roomService: RoomService, private router: Router) {}

  ngOnInit() {
    this.roomService.hasRoom().subscribe(hasRoom => {
      this.router.navigate(['/join'], { queryParams: { hasRoom } });
    });
  }

}
