import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

import { CardDetailComponent } from './card-detail/card-detail.component';
import { PaymentService } from '../shared/service/payment.service';

import { Payment } from '../shared/model/payment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'payvision-frontend';

  filterAction = '';
  filterCurrencyCode = '';

  actions = ['Payment', 'Authorize', 'Credit'];
  currencies = ['USD', 'EUR', 'GBP'];

  payments: Payment[];

  constructor(
    protected paymentService: PaymentService,
    protected modalService: NgbModal,
    protected toastrService: ToastrService
  ){}

  ngOnInit(): void {
    this.loadPayments();
  }

  showCardDetails(payment: Payment) {
    const modal = this.modalService.open(CardDetailComponent);
    modal.componentInstance.payment = payment;

    modal.result.then(
      () => {},
      () => {}
    )
  }

  changeAction(action) {
    this.filterAction = action.target.value.toLowerCase();
  }

  changeCurrency(currency) {
    this.filterCurrencyCode = currency.target.value.toUpperCase();
  }

  loadPayments() {
    this.paymentService.getPayments(this.filterAction, this.filterCurrencyCode).subscribe(
      (result: HttpResponse<Payment[]>) => {
        this.payments = result.body;
      },
      (error: HttpErrorResponse) => {
        this.showError()
      }
    );
  }

  showError() {
    this.toastrService.error("Error with communication to server", "Problem");
  }
}
