import { ImageCar } from "./image-car";

export interface CarPreview {
  id?: number,
  name: string,
  rentPrizePerDay: number,
  acceleration: number,
  power: number,
  torque: number,
  seats: number,
  transmission: string,
  productionYear: number,
  imageCarList: ImageCar[],
}
