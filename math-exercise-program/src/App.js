import React, { useState, useEffect } from 'react';

const MathExerciseProgram = () => {
  const [operand1, setOperand1] = useState(0);
  const [operand2, setOperand2] = useState(0);
  const [operator, setOperator] = useState('+');
  const [userAnswer, setUserAnswer] = useState('');
  const [correctAnswer, setCorrectAnswer] = useState(null);
  const [score, setScore] = useState(0);

  const generateRandomNumber = () => Math.floor(Math.random() * 21); // Generate numbers from 0 to 20

  const generateExercise = () => {
    const newOperand1 = generateRandomNumber();
    const newOperand2 = generateRandomNumber();
    const newOperator = Math.random() > 0.5 ? '+' : '-'; // Randomly choose addition or subtraction
    const answer = newOperator === '+' ? newOperand1 + newOperand2 : newOperand1 - newOperand2;

    setOperand1(newOperand1);
    setOperand2(newOperand2);
    setOperator(newOperator);
    setCorrectAnswer(answer);
    setUserAnswer('');
  };

  const handleAnswerChange = (event) => {
    const inputValue = event.target.value;

    // Allow only numeric input
    if (/^[0-9]*$/.test(inputValue)) {
      setUserAnswer(inputValue);
    }
  };

  const checkAnswer = () => {
    const userAnswerInt = parseInt(userAnswer, 10);
    if (!isNaN(userAnswerInt) && userAnswerInt === correctAnswer) {
      setScore(score + 1);
    }
    generateExercise();
  };

  useEffect(() => {
    generateExercise();
  }, []); // Run once when the component mounts

  return (
    <div>
      <h1>Math Exercise Program</h1>
      <p>Score: {score}</p>
      <p>
        {operand1} {operator} {operand2} ={' '}
        <input
          type="text"
          value={userAnswer}
          onChange={handleAnswerChange}
          onKeyPress={(e) => e.key === 'Enter' && checkAnswer()}
        />
      </p>
    </div>
  );
};

export default MathExerciseProgram;
