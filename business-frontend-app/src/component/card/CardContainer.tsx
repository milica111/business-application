import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { BusinessEntry } from '../../model/BusinessEntry';
import Card from './Card'

interface CardContainerInterface{
    id:string;
}

export default function CardContainer ({id}:CardContainerInterface){

const[businessEntry, setBusinessEntry]= useState<BusinessEntry|undefined>();
useEffect(()=>{
getBusinessEntry();
},[]);

const getDay=(day:string)=>{
    let result=day;
    if(day.includes(" "))
    result=day.substring(0,day.indexOf(" "))+"-"+day.substring(day.lastIndexOf(" "),day.length);
    return result.toLocaleUpperCase();
}

const getBusinessEntry=()=>{
        axios.get("http://localhost:8080/business-mgmt/business-entry/"+id).then((result:any)=> {
        setBusinessEntry(result.data)});
}


const isClosedDay=(day:string)=>{
    let isClosed=true;
    if(businessEntry)Object.keys(businessEntry?.opening_hours?.days).map((key:string)=>{
        if(key.includes(day)) isClosed= false;
    })
    return isClosed;
}

return(
    <Card businessEntry={businessEntry} getDay={getDay } isClosedDay={isClosedDay} ></Card>
)
}