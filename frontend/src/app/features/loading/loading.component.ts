import { Component } from '@angular/core';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { Router, RouterModule } from '@angular/router';
import { RoomService } from '../../core/service/room.service';

@Component({
  selector: 'app-loading',
  imports: [RouterModule, MatProgressSpinnerModule],
  templateUrl: './loading.component.html',
  styleUrl: './loading.component.css'
})
export class LoadingComponent {

  private loadingLabels: string[] = [
    'Verificando sala',
    'Aguardando jogadores',
    'Quase lá...'
  ];
  private currentLabelIndex = 0;

  constructor(private roomService: RoomService, private router: Router) {}

  get loadingLabel(): string {
    return this.loadingLabels[this.currentLabelIndex];
  }

  ngOnInit() {
    setInterval(() => {
      this.currentLabelIndex = (this.currentLabelIndex + 1) % this.loadingLabels.length;
    }, 1500);

    this.roomService.hasRoom().subscribe(hasRoom => {
      this.router.navigate(['/join'], { queryParams: { hasRoom } });
    });
  }

}
