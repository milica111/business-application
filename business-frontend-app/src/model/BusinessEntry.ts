import { OpeningHours } from "./OpeningHours";

export interface BusinessEntry{
    displayed_what:string;
    displayed_where:string;
    opening_hours:OpeningHours;
}
