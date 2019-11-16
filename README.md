# GeneticRace #
<a><img src="https://github.com/vbabenk/GeneticRace/blob/master/Babenko/Images/logo.png" title="GeneticRace" alt="GeneticRace"></a>

## Description ##
This is bachelor thesis project for Igor Sikorsky Kyiv Polytechnic Institute.

Project is a system for finding a treatment strategy for patients with congenital heart defects with a single ventricle using group method of data handling, analytic hierarchy process and genetic algorithms

Patients were treated in 2 stages: at first they underwent various operations, then they were given medications to improve their well-being.

The task was to build an algorithm for finding operational and conservative (using medications) treatment strategies in order to optimize the condition of patients after.

### Group method of data handling (GMDH) ###
- GMDH was used for building classification models.
- Models were built in <a href="https://gmdhsoftware.com/docs/">**GMDH Shell DS**</a> software.
- Data sample was divided into training (**85%**) and test (**15%**) samples.
- In total, **18 models** were built.
- Accuracy of models on test sample varies from **75.9%** to **96.6%**.
- Sensitivity on test sample varies from **0.814** to **1**.
- Specificity on test sample varies from **0.73** to **1**.

### Analytic hierarchy process (AHP) ###
- AHP was used to optimize criteria of condition of patients after treatments.
- Criteria of condition are **9** condition variables in **early postoperative period** and **9** condition variables in **late postoperative period**. For these variables classification models were built.

### Genetic algorithm (GA) ###
- GA was used to quickly find a treatment strategy.
- In average, solution is found in **20 seconds** and **700 iterations** of the GA's cycle.

## Sources ##

<a href="http://www.gmdh.net/">**1. Group Method of Data Handling.**</a><br />
<a href="https://www.youtube.com/watch?v=J4T70o8gjlk">**2. Manoj, Mathew. Analytic Hierarchy Process (AHP). 2018.**</a><br />
3. Saaty, Thomas L. Decision Making for Leaders: The Analytic Hierarchy Process for Decisions in a Complex World. RWS Publications, 1990.<br />
<a href = "https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3">**4. Mallawaarachchi, Vijini. Introduction to Genetic Algorithms. 2017.**</a><br />
<a href = "https://www.youtube.com/watch?v=1i8muvzZkPw">**5. What Is a Genetic Algorithm. 2015.**</a><br />
6. Goldberg, David E. Genetic Algorithms in Search, Optimization & Machine Learning. Addison-Wesley Publishing Company, Inc., 1989, p. 432.
