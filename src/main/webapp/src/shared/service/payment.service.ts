import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Payment } from '../model/payment';

import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  public resourceUrl = environment.backend_url + "/payments";

  constructor(
    protected httpClient: HttpClient
  ) { }

  getPayments(action: string, currencyCode: string): Observable<HttpResponse<Payment[]>> {
    let alreadyInserted = false;
    let finalUrl = this.resourceUrl;

    if(action !== '') {
      alreadyInserted = true;
      finalUrl = finalUrl + '?action=' + action;
    }

    if(currencyCode !== '') {
      if(alreadyInserted) {
        finalUrl = finalUrl + '&currencyCode=' + currencyCode;
      } else {
        finalUrl = finalUrl + '?currencyCode=' + currencyCode;
      }
    }

    return this.httpClient.get<Payment[]>(finalUrl, {observe: 'response'});
  }
}
