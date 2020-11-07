import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { GerenciadorDeIncidenteSharedModule } from 'app/shared/shared.module';
import { GerenciadorDeIncidenteCoreModule } from 'app/core/core.module';
import { GerenciadorDeIncidenteAppRoutingModule } from './app-routing.module';
import { GerenciadorDeIncidenteHomeModule } from './home/home.module';
import { GerenciadorDeIncidenteLoginPageModule } from './login/login-page.module';
import { GerenciadorDeIncidenteEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    GerenciadorDeIncidenteSharedModule,
    GerenciadorDeIncidenteCoreModule,
    GerenciadorDeIncidenteHomeModule,
    GerenciadorDeIncidenteLoginPageModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    GerenciadorDeIncidenteEntityModule,
    GerenciadorDeIncidenteAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent],
})
export class GerenciadorDeIncidenteAppModule {}
