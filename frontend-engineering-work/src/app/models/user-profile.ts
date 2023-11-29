import { Person } from "./person";
import { ReservationView } from "./reservation-view";


export interface UserProfile {
  id?: number;
  person: Person;
  email: string;
  mobilePhone: string;
  reservationViewList: ReservationView[];
}
