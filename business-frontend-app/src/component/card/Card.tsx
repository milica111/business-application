import React from 'react';
import { BusinessEntry } from '../../model/BusinessEntry';
import daysInWeek from '../../model/DaysInWeek';
import CardStyle from './CardStyle';

interface CardInterface{
    businessEntry:BusinessEntry|undefined;
    getDay:(day:string)=>string;
    isClosedDay:(day:string)=>boolean;
}

export default function Card ({businessEntry,getDay, isClosedDay}:CardInterface){
    
return(
    <div style={CardStyle.card}>
    <div style={CardStyle.name}>{businessEntry?.displayed_what}</div>
    <hr style={CardStyle.line}></hr>
    <div>{businessEntry?.displayed_where}</div>
    <hr style={CardStyle.line}></hr>
    <img src={require("../../image/clock.jpg")} style={CardStyle.image} alt={"clock"}/>
    <div>
        { businessEntry?.opening_hours?.days && Object.keys(businessEntry?.opening_hours?.days).map((key, index) => (
            <div key={index}>
                <div>{getDay(key)}</div>
            <div>{businessEntry?.opening_hours?.days[key].map((e:any, index:any)=>
                <div key={index} style={CardStyle.hours}>{e.start+ "-"+ e.end}</div>
                )}
            </div>
            <br/>
        </div>
        ))}
        {
            daysInWeek.map((day:string)=>{
                if(isClosedDay(day)) return <><div key={day}>{getDay(day)+" - CLOSED"}</div><br/></>
            })
        }
    </div>
    </div>
)
}