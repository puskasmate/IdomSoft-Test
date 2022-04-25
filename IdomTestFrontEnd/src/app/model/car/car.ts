import { Fuel } from "../fuel/fuel";

export class Car {
    id!: number;
    licensePlateNumber!: string;
    model!: string;
    fuelType!: string;
    numberOfPassengers!: number;
    color!: string;
    year!: number;
    consumption!: number;
    fuel!: Fuel
}
