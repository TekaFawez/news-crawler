import { Component } from '@angular/core';
import { NewsService } from '../../services/news.service';


@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrl: './news.component.css'
})
export class NewsComponent {
  query: string = '';
  articles: any[] = [];
   paginatedArticles: any[] = [];

  constructor(private newsService: NewsService) { }
  search() {
    this.newsService.searchNews(this.query).subscribe({
        next: data => {
            this.articles = data;
        },
        error: err => {
            console.log(err);
        }
    });
}




}
