type FlexDirection = "column" | "inherit" | "-moz-initial" | "initial" | "revert" | "unset" | "column-reverse" | "row" | "row-reverse" | undefined;

const CardStyle={
card:{
    flexDirection:"column" as FlexDirection, 
    boxShadow:"0 4px 8px 0 rgba(0,0,0,0.2)", 
    margin:"3%", 
    width:"50%",
    height:"inherit"
},
hours:{
    fontSize:"100%"
},
line:{
    borderTop: "3px solid #bbb"

},
name:{
    fontFamily:"sans-serif",
     fontSize:"150%",
      color:"#63C5DA"
},
image:{
    height:"20%",
    width:"20%"
}

}
export default CardStyle;