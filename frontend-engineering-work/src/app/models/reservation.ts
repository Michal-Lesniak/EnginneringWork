
export interface Reservation {
  id?: number,
  carId: number,
  userId: number,
  rentCityId: number,
  arrivalCityId: number,
  rentDate: Date,
  arrivalDate: Date,
}
