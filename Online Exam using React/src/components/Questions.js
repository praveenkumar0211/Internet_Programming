// const questions = [{
//         ques: "Which of the following is an example of non-volatile memory?",
//         options: [
//             { text: "Cache memory", isCorrect: false },
//             { text: "RAM", isCorrect: false },
//             { text: "ROM", isCorrect: true },
//             { text: "None of the Above", isCorrect: false }
//         ],
//         ans: "ROM"
//     },
//     {
//         ques: "How many buses are connected as part of the 8085 microprocessor?",
//         options: [
//             { text: "2", isCorrect: false },
//             { text: "3", isCorrect: false },
//             { text: "5", isCorrect: false },
//             { text: "8", isCorrect: true }
//         ],
//         ans: "8"
//     },
//     {
//         ques: "The term ‘page traffic’ describes",
//         options: [
//             { text: "Number of pages in memory at a given instant", isCorrect: false },
//             { text: "Number of papers required to be brought in at a given page request", isCorrect: false },
//             { text: "Number of pages of executing programs loaded in memory", isCorrect: false },
//             { text: "The movement of pages in and out of memory", isCorrect: true }
//         ],
//         ans: "The movement of pages in and out of memory"
//     }, {
//         ques: "An assembler is",
//         options: [
//             { text: "Syntax dependant", isCorrect: false },
//             { text: "Machine dependant", isCorrect: true },
//             { text: "Data dependant", isCorrect: false },
//             { text: "Programming language-dependent", isCorrect: false }
//         ],
//         ans: "Machine dependant"
//     },

//     {
//         ques: "Concepts of OOPS include : ",
//         options: [
//             { text: "Data encapsulation", isCorrect: true },
//             { text: "Data authentication", isCorrect: false },
//             { text: "Inheritance", isCorrect: true },
//             { text: "Compilation", isCorrect: false }
//         ],
//         ans: ["Inheritance", "Data encapsulation"]
//     },
//     {
//         ques: "Which of the following is true ?",
//         options: [
//             { text: "Ajax is a programming language", isCorrect: false },
//             { text: "Node.js is a runtime environment", isCorrect: true },
//             { text: "React is a front-end JS library", isCorrect: true },
//             { text: "Express is a front-end JS framework", isCorrect: false }
//         ],
//         ans: ["Node.js is a runtime environment", "React is a front-end JS library"]
//     },
//     {
//         part1: "The first part of a machine language instruction that specifies the operation to be performed is called a(n)",
//         part2: "Note: one word, lower case letters only",
//         ans: "opcode"
//     },
//     {
//         part1: "When the Lagrangian multiplier value is not zero then the vector is called",
//         part2: "vector. Note: one word, lower case letters only",
//         ans: "support"
//     },
//     {
//         part1: "Solve: In data set S, if the no. of samples n=4,P+=1,p−=3, then the Entropy(S) is",
//         part2: "note: real number, after decimal point two digits only, no space before and after decimal point",
//         ans: "0.81"
//     },
//     {
//         part1: "Solve: The value of  information gain of the following data set is",
//         part2: "S={s1, s2, s3, s4} where s1=false, s2=true, s3=false, s4=true F={f1, f2} where f1 = s1, s2 and f2 = s3, s4 Note: only number.",
//         ans: "0"
//     }

// ]

const questions=[
    {
        question: "A user sends the name and address form to the server. Which method is used?",
        options:[
        {text: "get()", isCorrect: false},
        {text: "init()", isCorrect: false},
        {text: "post()", isCorrect: true},
        {text: "service()", isCorrect: false}
        ],
        ans: "post()"
    },
    {
        question: "A missing image when trying to be displayed can be managed using:",
        options:[
        {text: "alt method", isCorrect: false},
        {text: "alt attribute", isCorrect: true},
        {text: "alternate method", isCorrect: false},
        {text: "none of the above", isCorrect: false}
        ],
        ans: "alt attribute"
    },
    {
        question: "Servlet's life cylce is managed by _________",
        options:[
        {text: "servlet context", isCorrect: false},
        {text: "servlet container", isCorrect: true},
        {text: "service", isCorrect: false},
        {text: "http", isCorrect: false}
        ],
        ans: "servlet container"
    },
    {
        question: "What package should be imported in servlets to work with JDBC?",
        options:[
        {text: "java.servlet.http.*", isCorrect: false},
        {text: "java.sql.*", isCorrect: true},
        {text: "java.servlet.JDBC ", isCorrect: false},
        {text: "java.servlet.* ", isCorrect: false}
        ],
        ans: "java.sql.*"
    },
    
    {
        question: "Which of the following objects can be used in expression and scriplets in JSP without explicitly declaring them?",
        options:[
        {text: "Request", isCorrect: true},
        {text: "Response", isCorrect: false},
        {text: "Session", isCorrect: true},
        {text: "None", isCorrect: false}
        ],
        ans: ["Request", "Session"]
    },
    {
        question: "From the following options indicate a correct association of the PROMPT, HEAD and RCPT commands with protocols where they are used?",
        options:[
        {text: "HTTP", isCorrect: true},
        {text: "SMTP", isCorrect: true},
        {text: "FTP", isCorrect: true},
        {text: "None", isCorrect: true}
        ],
        ans: ["HTTP", "SMTP"]
    },
    {
        question: "If you want to align text in CSS, which property would you use?(Note: Single hyphenated word, lower case letters only)",
        ans: "text-align"
    },
    {
        question: "Which attribute specifies a unique alphanumeric identifier to be associated with an element?(Note: lower case letters only)",
        ans:"id"
    },
    {
        question: "Event listener used when a user moves the pointer over a <p> tag is _________(note: lower case letters only)",
        ans:"onmouseover"
    },
    {
        question: "The _____________ attribute specifies an inline style associated with an element, which determines the rendering of the affected element.(note: lower case letters only)",
        ans:"style"
    }

]


export default questions;