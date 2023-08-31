function add(n1, n2, resultType) {
    var result;
    if (typeof n1 === 'number' || resultType == 'asNumber') {
        result = +n1 + +n2;
    }
    else {
        result = number1.toString() + n2;
    }
    return result;
}
var number1 = 5;
var number2 = 2.5;
var printResult = true;
var Role;
(function (Role) {
    Role[Role["MANAGER"] = 10] = "MANAGER";
    Role["ADMIN"] = "Admin";
    Role[Role["DEV"] = 11] = "DEV";
})(Role || (Role = {}));
;
var person = {
    name: 'Deven',
    age: 40,
    hobbies: ['sport'],
    role: Role.MANAGER
};
person.role[0] = 10;
var result = add(number1, number2, 'asNumber');
console.log(result);
var re1 = add('abc', 123, 'asString');
function printTextResult(text) {
    console.log('I am ' + text);
}
var fa = add;
var fa1;
// fa1 = fa; //fail
var fa2;
fa2 = function (a, b) { return fa1(a, b).toString(); };
printTextResult(fa('123', 123, 'asString'));
function addAndHandle(n1, n2, cb) {
    var result = n1 + n2;
    cb(result);
}
addAndHandle(10, 20, function (result) { return printTextResult(result.toString()); });
