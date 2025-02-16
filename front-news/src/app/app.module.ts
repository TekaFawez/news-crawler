import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { MatPaginator } from '@angular/material/paginator';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './components/news/news.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
// import { MatButtonModule } from '@angular/material/button';
// import { MatCardModule} from "@angular/material/card";
// import { MatInputModule} from "@angular/material/input";
@NgModule({
  declarations: [
    AppComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    // MatPaginator,
    // MatCardModule,      
    // MatButtonModule,    
    // MatInputModule      
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
