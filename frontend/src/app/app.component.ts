import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { WebsocketService } from './core/service/websocket.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  constructor(
    private websocketService: WebsocketService,
    private router: Router
  ) {}

  ngOnInit() {
    if(!this.websocketService.isConnected)
      this.router.navigate(['/']);
  }
  
}
