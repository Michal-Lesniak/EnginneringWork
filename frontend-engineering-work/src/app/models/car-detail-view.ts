import { CarModel } from "./car-model";

export interface CarDetailView {
  id?: number;
  brand: string;
  rentPrizePerDay: number;
  model: CarModel;
  productionYear: number;
  bookedDays: Date[];
}
