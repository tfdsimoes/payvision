export class Card {
  constructor(
    public expiryMonth?: string,
    public expiryYear?: string,
    public firstSixDigits?: string,
    public lastFourDigits?: string,
    public holderName?: string
  )
  {}
}
