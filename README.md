# GeneticRace
<a><img src="https://github.com/vbabenk/GeneticRace/blob/master/Babenko/Images/logo.png" title="GeneticRace" alt="GeneticRace"></a>

## Description
This is bachelor thesis project for Igor Sikorsky Kyiv Polytechnic Institute.

Project is a system for finding a treatment strategy for patients with congenital heart defects with a single ventricle using group method of data handling, analytic hierarchy process and genetic algorithms

Patients were treated in 2 stages: at first they underwent various operations, then they were given medications to improve their well-being.

The task was to build an algorithm for finding operational and conservative (using medications) treatment strategies in order to optimize the condition of patients after.

### Group method of data handling (GMDH)
- GMDH was used for building classification models. 
- Data sample was divided into training (<b>85%</b>) and test (<b>15%</b>) samples.
- In total, <b>18 models</b> were built.
- Accuracy of models on test sample varies from <b>75.9%</b> to <b>96.6%</b>.
- Sensitivity on test sample varies from <b>0.814</b> to <b>1</b>.
- Specificity on test sample varies from <b>0.73</b> to <b>1</b>.

### Analytic hierarchy process (AHP)
- AHP was used to optimize criteria of condition of patients after treatments.
- Criteria of condition are <b>9</b> condition variables in <b>early postoperative period</b> and <b>9</b> condition variables in <b>late postoperative period</b>. For these variables classification models were built.

### Genetic algorithm (GA)
- GA was used to quickly find a treatment strategy.
- In average, solution is found in <b>20 seconds</b> and <b>700 iterations</b> of the GA's cycle.
