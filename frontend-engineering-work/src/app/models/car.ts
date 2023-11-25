import { CarModel } from "./car-model";

export interface Car {
  id: number;
  brand: string;
  rentPrizePerDay: number;
  model: CarModel;
  productionYear: number;
}
