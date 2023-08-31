type Combinable = number | string;
type StrinNumberType =  'asString' | 'asNumber';

function add(n1: Combinable, n2: number, resultType: StrinNumberType) {
    let result;
    if (typeof n1 === 'number' || resultType == 'asNumber') {
        result = +n1 + +n2;
    } else {
        result = number1.toString() + n2;
    }
    return result;
}

const number1 = 5;
const number2 = 2.5;
const printResult = true;
enum Role { MANAGER = 10, ADMIN = 'Admin', DEV = 11};
const person : {
    name: string;
    age: number;
    hobbies: string[];
    role: Role
} = {
    name: 'Deven',
    age:40,
    hobbies: ['sport'],
    role: Role.MANAGER
}

person.role[0] = 10;

const result = add(number1, number2, 'asNumber');
console.log(result);

const re1 = add('abc', 123, 'asString');

function printTextResult(text: string) : void {
    console.log('I am ' + text);
}
let fa : Function = add;
let fa1 : (a: number, b: number) => number;
// fa1 = fa; //fail
let fa2 : (a: number, b: number) => string;
fa2 = (a, b) => fa1(a, b).toString();

printTextResult(fa('123' , 123, 'asString'));


function addAndHandle(n1: number, n2: number, cb: (num: number) => void) {
    const result = n1 + n2;
    cb(result);
}

addAndHandle(10, 20, (result) => printTextResult(result.toString()));