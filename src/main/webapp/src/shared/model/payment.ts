import {Card} from './card';

export class Payment {
  constructor(
    public action?: string,
    public amount?: number,
    public brandId?: number,
    public brandName?: string,
    public card?: Card,
    public currencyCode?: string,
    public id?: string,
    public trackingCode?: string
  ){}
}
