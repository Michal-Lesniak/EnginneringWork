import { Car } from "./car";
import { User } from "./user";

export interface Reservation {
  id: number,
  car: Car,
  rentDate: Date,
  arrivalDate: Date,
  user: User,
  rentCity: string,
  arrivalCity: string
}
