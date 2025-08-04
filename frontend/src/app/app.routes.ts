import { Routes } from '@angular/router';
import { LoadingComponent } from './features/loading/loading.component';
import { RoomComponent } from './features/room/room.component';
import { JoinComponent } from './features/join/join.component';

export const routes: Routes = [
    { path: '', component: LoadingComponent },
    { path: 'room', component: RoomComponent },
    { path: 'join', component: JoinComponent },
];
