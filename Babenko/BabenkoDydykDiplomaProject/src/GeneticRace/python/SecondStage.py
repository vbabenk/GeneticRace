from random import randint, choices
import copy
from scipy.stats.mstats import gmean
import sqlite3

populationNumber = 32
populationRange = range(populationNumber)


def calculateCriterions(xList, solList):
    x301 = xList[0]
    x302 = xList[1]
    x303 = xList[2]
    x304 = xList[3]
    x305 = xList[4]
    x306 = xList[5]
    x307 = xList[6]
    x308 = xList[7]
    x309 = xList[8]
    criterionList = []
    for uList in solList:
        x401 = uList[0]
        x402 = uList[1]
        x403 = uList[2]
        x404 = uList[3]
        x405 = uList[4]
        x406 = uList[5]
        x407 = uList[6]
        x408 = uList[7]
        x409 = uList[8]
        x501EqualsTwo = 0.203898 + x301 ** (-1) * x405 ** (-1) * 0.910959 + x404 ** (
            -1) * x405 * 0.427516 + x403 * x406 ** (-1) * (-3.25314) + x301 * x403 * 4.30283 + x404 * x405 ** (-1) * (
                            -0.0507695) + x303 * x403 * (-1.25164) + x304 ** (-1) * x405 ** (-1) * (
                            -1.13018) + x401 * x409 ** (-1) * 0.013292 + x308 * x309 ** (-1) * (-0.382442) + x306 ** (
                            -1) * x404 ** (-1) * (-2.07729) + x401 ** (-1) * x409 * 1.05208 + x402 ** (-1) * x407 ** (
                            -1) * (-19.254) + x404 * x409 * (-0.0224005) + x305 ** (-1) * x401 ** (-1) * (
                            -10.406) + x305 ** (-1) * x404 * 0.101907 + x401 ** (-1) * x405 ** (
                            -1) * 3.49662 + x302 ** (-1) * x405 ** (-1) * 1.15775 + x302 * x303 * 0.17399 + x401 ** (
                            -1) * x404 ** (-1) * (-7.90677) + x301 * x407 * (-0.122005) + x308 * x402 ** (
                            -1) * 5.83819 + x301 ** (-1) * x404 * (-0.0369662) + x401 ** (-1) * x407 ** (-1) * 2.73641
        x502EqualsTwo = -0.471431 + x305 ** (-1) * x406 ** (-1) * 1.09482 + x403 * x408 * (
            -3.06197) + x304 * x403 * 2.72805 + x302 ** (-1) * x401 ** (-1) * 2.92486 + x304 ** (-1) * x307 ** (
                            -1) * 1.72336 + x402 ** (-1) * x408 ** (-1) * (-5.41859) + x402 * x404 ** (-1) * (
                            -0.0445508) + x405 * x407 ** (-1) * (-0.298849) + x308 ** (-1) * x405 ** (-1) * (
                            -1.36086) + x301 * x407 ** (-1) * 1.09577 + x301 * x405 ** (-1) * (-0.783258) + x402 ** (
                            -1) * x404 * (-0.493502) + x401 * x404 ** (-1) * 0.0744676 + x405 ** (
                            -1) * x406 * 0.265279 + x406 ** (-1) * x407 * 0.501585 + x303 ** (-1) * x409 * (
                            -0.36206) + x405 ** (-1) * x407 ** (-1) * 0.802625 + x304 ** (-1) * x406 ** (-1) * (
                            -1.03788)
        x503EqualsTwo = 1.95339 + x408 ** (-1) * x409 ** (-1) * 0.32464 + x308 ** (-1) * x404 ** (
            -1) * 2.31705 + x407 * x408 * (-0.276162) + x407 ** (-1) * x408 ** (-1) * (-2.4394) + x304 * x406 * (
                            -0.111947) + x404 * x407 ** (-1) * 0.0305552 + x405 ** (-1) * x408 ** (
                            -1) * 1.27569 + x401 * x405 ** (-1) * (-0.0607239) + x401 ** (-1) * x409 * (
                            -1.0994) + x303 ** (-1) * x401 * 0.0271928
        x504EqualsTwo = 1.06655 + x403 * x409 ** (-1) * 3.59357 + x406 ** (-1) * x407 ** (-1) * (
            -1.19368) + x404 * x405 * (-0.00880017) + x308 ** (-1) * x407 ** (-1) * 2.06499 + x401 * x403 * (
                            -0.150814) + x402 * x407 ** (-1) * 0.011523 + x301 ** (
                            -1) * x407 * 0.6211 + x401 * x405 ** (-1) * 0.0241819 + x401 * x404 ** (-1) * (
                            -0.0143991) + x301 * x405 * 0.136269 + x405 * x407 * (-0.00884287) + x407 * x408 * (
                            -0.211492) + x404 * x407 * 0.00221758 + x303 ** (-1) * x307 ** (-1) * (-1.33289) + x301 ** (
                            -1) * x308 ** (-1) * (-1.01545) + x405 * x408 ** (-1) * (-0.206286) + x305 ** (
                            -1) * x309 * (-0.303684) + x402 ** (-1) * x409 * (-1.84102) + x301 * x401 ** (-1) * 0.514069
        x505EqualsTwo = 0.091119 + x308 ** (-1) * x406 ** (-1) * 1.15482 + x304 * x309 * (-0.234552) + x303 * x305 ** (
            -1) * (-0.468262) + x401 * x402 * (-0.00120581) + x407 ** (-1) * x408 ** (
                            -1) * 2.20372 + x407 * x408 * 0.203365 + x301 ** (-1) * x408 ** (-1) * (
                            -0.224786) + x403 * x407 ** (-1) * 1.75401 + x402 * x404 ** (
                            -1) * 0.0515831 + x401 * x408 ** (-1) * 0.0186275 + x306 ** (-1) * x403 * (
                            -3.10445) + x404 * x408 * 0.0266439 + x302 * x407 * (-0.143367) + x302 ** (-1) * x407 ** (
                            -1) * (-0.655295) + x403 * x409 ** (-1) * 3.61478 + x403 * x408 ** (-1) * (
                            -4.82115) + x401 ** (-1) * x404 * (-0.222182) + x401 ** (-1) * x405 ** (
                            -1) * 1.68566 + x403 * x404 * 0.154106 + x404 ** (
                            -1) * x406 * 1.94052 + x401 * x407 * 0.0123596 + x404 ** (-1) * x407 ** (-1) * (
                            -1.7251) + x304 ** (-1) * x406 * (-0.303317) + x306 * x404 ** (-1) * (-0.768984) + x303 ** (
                            -1) * x402 ** (-1) * 6.71103
        x506EqualsTwo = 1.22334 + x403 * x406 * 0.64041 + x402 ** (
            -1) * x404 * 1.92831 + x305 * x307 * 0.186573 + x403 * x404 * (-0.204982) + x401 ** (-1) * x408 ** (-1) * (
                            -12.1129) + x304 ** (-1) * x401 ** (-1) * 7.87555 + x309 ** (-1) * x408 * (
                            -2.69499) + x302 * x304 ** (-1) * 0.874263 + x401 ** (-1) * x402 * 0.113644 + x303 ** (
                            -1) * x402 ** (-1) * 58.3697 + x303 ** (-1) * x401 ** (-1) * (-8.91198) + x309 * x402 ** (
                            -1) * (-57.1008) + x301 ** (-1) * x402 ** (-1) * 12.9686 + x402 ** (
                            -1) * x409 * 11.804 + x408 * x409 ** (-1) * 1.0522 + x308 ** (-1) * x404 * (
                            -0.0536574) + x305 ** (-1) * x403 * 2.98424 + x302 * x409 ** (-1) * (
                            -1.11811) + x304 * x402 ** (-1) * 25.7593 + x405 ** (-1) * x407 * 0.086348 + x401 ** (
                            -1) * x409 ** (-1) * 5.31789 + x401 * x409 * (-0.00743753)
        x507EqualsTwo = 2.70189 + x301 ** 2 * 0.387945 + x305 * x308 * (-0.0851309) + x306 * x307 * (
            -0.232534) + x302 * x409 * 0.0657112 + x303 * x408 * 0.208682 + x403 * x407 * (
                            -2.58931) + x403 * x405 * 2.53922 + x402 * x403 * (-0.205441) + x301 * x408 * (
                            -0.624969) + x401 * x404 * (
                            -0.00361108) + x301 * x401 * 0.014996 + x402 * x404 * 0.000855651 + x302 * x401 * (
                            -0.0180873) + x403 * x409 * 3.3802 + x302 * x403 * (
                            -4.60527) + x304 * x403 * 8.3029 + x303 * x304 * (
                            -0.192993) + x407 * x408 * 0.22353 + x407 * x409 * (-0.159675) + x302 * x309 * (
                            -0.118495) + x301 * x403 * (-7.86307) + x406 * x407 * (-0.0519393) + x403 ** 2 * (
                            -10.6638) + x403 * x408 * 3.47469 + x403 * x406 * (-1.3094) + x401 ** 2 * 0.000791461
        x508EqualsTwo = 0.491547 + x302 * x408 * 0.293381 + x402 * x407 * (-0.00138491) + x403 * x404 * (
            -0.10257) + x405 * x406 * 0.102928 + x301 * x304 * 0.150368 + x401 * x408 * (-0.0278252) + x404 * x405 * (
                            -0.00818883) + x404 * x409 * 0.0115062 + x308 * x406 * (
                            -0.45356) + x304 * x406 * 0.439602 + x304 * x306 * (
                            -0.153749) + x305 * x401 * 0.040654 + x401 * x407 * (-0.0169291) + x401 * x402 * (
                            -0.000416154) + x304 * x305 * (-0.142557)
        x509EqualsTwo = 2.24957 + x307 * x308 * (-0.184216) + x401 ** (-1) * x404 * 0.149113 + x302 * x404 * (
            -0.0107084) + x402 ** (-1) * x407 ** (-1) * (-8.19724) + x403 * x405 ** (-1) * (
                            -6.10407) + x403 * x409 * 3.4668 + x408 ** (-1) * x409 * (
                            -0.35094) + x301 * x401 * 0.0394856 + x306 * x401 * (-0.0306855) + x302 * x303 ** (-1) * (
                            -0.230414) + x405 * x407 * (-0.0215096) + x301 * x408 * (-0.109036) + x306 ** (
                            -1) * x403 * (-2.45236) + x304 ** (-1) * x306 ** (-1) * 0.715238
        x501 = 1 if (round(x501EqualsTwo) == 0) else 2
        x502 = 1 if (round(x502EqualsTwo) == 0) else 2
        x503 = 1 if (round(x503EqualsTwo) == 0) else 2
        x504 = 1 if (round(x504EqualsTwo) == 0) else 2
        x505 = 1 if (round(x505EqualsTwo) == 0) else 2
        x506 = 1 if (round(x506EqualsTwo) == 0) else 2
        x507 = 1 if (round(x507EqualsTwo) == 0) else 2
        x508 = 1 if (round(x508EqualsTwo) == 0) else 2
        x509 = 1 if (round(x509EqualsTwo) == 0) else 2
        cList = [x501, x502, x503, x504, x505, x506, x507, x508, x509]
        criterionList.append(cList)
    return criterionList


def calculatePerfectValue(xList, coeffList):
    x301 = xList[0]
    x302 = xList[1]
    x307 = xList[6]
    x501 = 1
    x502 = 1
    x503 = 1
    x504 = 1
    x505 = 1
    x506 = 1
    x507 = 1
    x508 = 1
    x509 = round(1.70408 + x302*x307*(-0.238892) + x301**2*0.170947)
    cList = [x501, x502, x503, x504, x505, x506, x507, x508, x509]
    saatiValue = 0
    for i in range(9):
        saatiValue -= cList[i] * coeffList[i]
    roundSaatiValue = round(saatiValue, 15)
    return roundSaatiValue


def checkEqual(iterator):
    return len(set(iterator)) <= 1


def saatiMethod():
    relationshipMatrix = []
    firstRow = [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
    relationshipMatrix.append(firstRow)
    for i in range(2, 10):
        nextRow = []
        for j in range(9):
            value = firstRow[j] / i
            nextRow.append(value)
        relationshipMatrix.append(nextRow)
    gmeanList = []
    for row in relationshipMatrix:
        gmeanList.append(gmean(row))
    priorityVectors = []
    for g in gmeanList:
        pVector = g / sum(gmeanList)
        priorityVectors.append(pVector)
    return priorityVectors


def generateFirstPopulation():
    solList = []
    for i in range(populationNumber):
        x401 = randint(1, 4200) / 100
        x402 = randint(1, 81)
        x403 = randint(0, 100) / 100
        x404 = randint(1, 25)
        x405 = randint(1, 7)
        x406 = randint(1, 4)
        x407 = randint(1, 3)
        x408 = randint(1, 2)
        x409 = randint(1, 2)
        uList = [x401, x402, x403, x404, x405, x406, x407, x408, x409]
        solList.append(uList)
    return solList


def calculateSaati(coeffList, criterionList):
    saatiList = []
    for cList in criterionList:
        saatiValue = 0
        for i in range(9):
            saatiValue -= cList[i] * coeffList[i]
        roundSaatiValue = round(saatiValue, 15)
        saatiList.append(roundSaatiValue)
    return saatiList


def getDiscrepancies(perfectValue, saatiList):
    discList = []
    for saatiValue in saatiList:
        disc = perfectValue - saatiValue
        discList.append(disc)
    return discList


def getProbabilities(discList):
    invList = []
    for disc in discList:
        inv = 1 / disc
        invList.append(inv)
    probList = []
    for inv in invList:
        prob = inv / sum(invList)
        probList.append(prob)
    return probList


def getMothers(fatherList, probList):
    motherList = []
    for i in range(populationNumber):
        m = choices(populationRange, probList)
        while m[0] == fatherList[i]:
            m = choices(populationRange, probList)
        motherList.append(m[0])
    return motherList


def crossover(solList, tempSolList, fatherList, motherList):
    for i in range(populationNumber):
        j = fatherList[i]
        k = motherList[i]
        for l in range(9):
            if l < (i % 8) + 1:
                solList[i][l] = tempSolList[j if ((i % 16) < 8) else k][l]
            else:
                solList[i][l] = tempSolList[k if ((i % 16) < 8) else j][l]
    return solList


def mutation(solList):
    i = 1
    while i < populationNumber:
        x401 = randint(1, 4200) / 100
        x402 = randint(1, 81)
        x403 = randint(0, 100) / 100
        x404 = randint(1, 25)
        x405 = randint(1, 7)
        x406 = randint(1, 4)
        x407 = randint(1, 3)
        x408 = randint(1, 2)
        x409 = randint(1, 2)
        uList = [x401, x402, x403, x404, x405, x406, x407, x408, x409]
        solList[i] = copy.deepcopy(uList)
        i += 1
    return solList


def calculateTreatment(xList):
    coeffList = saatiMethod()
    perfectValue = calculatePerfectValue(xList, coeffList)
    treatmentList = []
    complicationList = []
    for iteration in range(20):
        solList = generateFirstPopulation()
        flag = False
        meanList = []
        while True:
            criterionList = calculateCriterions(xList, solList)
            saatiList = calculateSaati(coeffList, criterionList)
            for i in range(populationNumber):
                if saatiList[i] == perfectValue:
                    treatmentList.append(solList[i])
                    complicationList.append(criterionList[i])
                    flag = True
                    break
            if flag:
                break
            else:
                discList = getDiscrepancies(perfectValue, saatiList)
                meanDiscrepancy = sum(discList) / len(discList)
                meanList.append(meanDiscrepancy)
                if len(meanList) > 2 and meanList[-2] == meanList[-1]:
                    newSolList = mutation(solList)
                    solList = copy.deepcopy(newSolList)
                else:
                    probList = getProbabilities(discList)
                    fatherList = choices(populationRange, probList, k=populationNumber)
                    if checkEqual(fatherList):
                        treatmentList.append(solList[fatherList[0]])
                        complicationList.append(criterionList[fatherList[0]])
                        break
                    motherList = getMothers(fatherList, probList)
                    tempSolList = copy.deepcopy(solList)
                    newSolList = crossover(solList, tempSolList, fatherList, motherList)
                    solList = copy.deepcopy(newSolList)
    with open('D:\\JavaProjects\\Babenko\\Files\\currentResult.txt', 'w') as f:
        for i in range(5):
            for item in treatmentList[i]:
                f.write("%s\n" % item)
        for item in complicationList[0]:
            f.write("%s\n" % item)
    f.close()


file = open("D:\\JavaProjects\\Babenko\\Files\\currentInput.txt", "r")
strLine = file.readline()
strList = strLine.split(' ')
xList = []
for strValue in strList:
    xList.append(float(strValue))
calculateTreatment(xList)
