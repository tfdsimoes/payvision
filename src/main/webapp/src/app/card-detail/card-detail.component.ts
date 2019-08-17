import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { Payment } from '../../shared/model/payment';

@Component({
  selector: 'app-card-detail',
  templateUrl: './card-detail.component.html',
  styleUrls: ['./card-detail.component.css']
})
export class CardDetailComponent implements OnInit {

  @Input() payment: Payment;

  constructor(
    private activeModal: NgbActiveModal
  ) { }

  ngOnInit() {
  }

  dismiss() {
    this.activeModal.dismiss();
  }
}
