import { Component } from '@angular/core';

@Component({
  selector: 'app-social-media',
  templateUrl: './social-media.component.html',
  styleUrls: ['./social-media.component.scss']
})
export class SocialMediaComponent {
  socialLinks = {
    instagram: 'https://www.instagram.com/majki-rent',
    facebook: 'https://www.facebook.com/majki-rent',
    youtube: 'https://www.youtube.com/majki-rent'
  };
}
