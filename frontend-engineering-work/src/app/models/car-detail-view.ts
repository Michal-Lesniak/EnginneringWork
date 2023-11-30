import { CarModel } from "./car-model";
import { ImageCar } from "./image-car";

export interface CarDetailView {
  id?: number,
  brand: string,
  rentPrizePerDay: number,
  model: CarModel,
  productionYear: number,
  bookedDays: Date[],
  imagePath?: ImageCar[],
}
