import { Engine } from "./engine";

export interface CarModel {
  id?:number,
  name:string,
  engine: Engine,
  type: string,
  seats:string,
  drive: string,
  transmission: string,
  topSpeed: string,
  fuelConsumption: string
  acceleration: number
}
