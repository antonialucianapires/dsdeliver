import { useState } from "react";

function Counter() {


//estado: usado quando queremos alterar o valor de uma variável, dinamicidade
const [counter, setCounter] = useState(0);

const incrementarValor = () => {
    setCounter(counter+1);
}

const decrementarValor = () => {
    setCounter(counter-1);
}

    return(
        <div>
            <button onClick={incrementarValor}>incrementar</button>
            <button onClick={decrementarValor}>decrementar</button>
            <h1>Valor do contador: {counter}</h1>
        </div>
    )
}

export default Counter;