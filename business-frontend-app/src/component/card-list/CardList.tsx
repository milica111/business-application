import React from 'react'
import IdCardArray from '../../IdCardArray'
import CardContainer from '../card/CardContainer'
import CardListStyle from './CardListStyle'

export default function CardList(){
    return(
        <div style={CardListStyle.cardList}>
        {IdCardArray.map((id:string)=>(<CardContainer id={id} key={id}></CardContainer>))

        }
        </div>
    )
}