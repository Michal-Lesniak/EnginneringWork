import { Person } from "./person";

export interface User {
  id: number;
  person: Person;
  email: string;
  mobilePhone: string;
}
