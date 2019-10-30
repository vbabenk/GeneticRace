from random import randint, choices
import copy
from scipy.stats.mstats import gmean
import sqlite3

populationNumber = 32
populationRange = range(populationNumber)


def calculateCriterions(xList, solList):
    x101 = xList[0]
    x102 = xList[1]
    x103 = xList[2]
    x104 = xList[3]
    x105 = xList[4]
    x106 = xList[5]
    x107 = xList[6]
    x108 = xList[7]
    x109 = xList[8]
    x110 = xList[9]
    x111 = xList[10]
    x112 = xList[11]
    criterionList = []
    for uList in solList:
        x201 = uList[0]
        x202 = uList[1]
        x203 = uList[2]
        x204 = uList[3]
        x205 = uList[4]
        x206 = uList[5]
        x207 = uList[6]
        x208 = uList[7]
        x209 = uList[8]
        x301EqualsTwo = -0.832705 + x111 ** (-1) * x201 * 0.00291197 + x106 * x208 * (-0.00135807) + x105 * x109 * (
            -0.00232767) + x101 ** (-1) * x112 * 17.0861 + x103 ** (-1) * x109 ** (
                            -1) * 10.4146 + x101 * x202 * 0.000502042 + x205 ** (-1) * x207 * 0.358865 + x109 ** (
                            -1) * x202 * (-0.00771969) + x202 * x204 ** (-1) * (-0.0530489) + x101 ** (-1) * x204 ** (
                            -1) * 35.5495
        x302EqualsTwo = 1.8959 + x103 * x104 * 4.62265e-05 + x105 * x205 ** (-1) * (-0.0705953) + x104 ** (
            -1) * x106 * (-0.0233172) + x201 ** (-1) * x207 ** (-1) * (-41.7888) + x107 ** (
                            -1) * x108 * 0.0905328 + x103 ** (-1) * x207 ** (-1) * (-121.413) + x111 * x209 ** (-1) * (
                            -0.585375) + x105 ** (-1) * x109 * 0.620899 + x106 ** (-1) * x109 ** (-1) * (
                            -2.62234) + x107 * x204 ** (-1) * 0.12513
        x303EqualsTwo = -0.0102022 + x201 ** (-1) * x203 ** (-1) * 716.757 + x106 * x209 * 0.00518668 + x103 ** (
            -1) * x106 * (-0.994431) + x103 * x112 * (-0.000324448) + x105 ** (-1) * x108 * (-1.12948) + x110 ** (
                            -1) * x209 * 0.247751 + x103 ** (-1) * x109 ** (-1) * (-2.46223) + x106 * x107 ** (-1) * (
                            -0.00429694) + x103 ** (-1) * x107 ** (-1) * 73.8395 + x108 * x204 * 0.0123085
        x304EqualsTwo = 1.44158 + x102 * x202 * (-0.00673552) + x105 * x112 * (-0.00959038) + x202 * x207 ** (
            -1) * 0.044888 + x206 * x209 ** (-1) * 0.518793 + x104 * x112 * (
                            -0.0113419) + x101 * x108 * 0.000239275 + x107 * x201 * (-0.00032867) + x105 ** (
                            -1) * x202 ** (-1) * (-11.7529) + x103 * x111 ** (-1) * 0.0013597 + x103 * x206 ** (-1) * (
                            -0.000968004)
        x305EqualsTwo = -1.6615 + x104 * x110 * (-0.0346257) + x105 ** (-1) * x112 * 3.10562 + x103 ** (-1) * x208 * (
            -21.4803) + x109 ** (-1) * x201 * 0.00047157 + x108 * x202 * 0.00862588 + x110 * x203 ** (
                            -1) * 10.1393 + x101 ** (-1) * x106 * (-0.159258) + x109 ** (-1) * x112 ** (-1) * (
                            -0.0942774) + x104 * x203 * 0.00720075 + x110 * x202 ** (-1) * 0.557958
        x306EqualsTwo = -0.975001 + x108 * x209 * 0.0475912 + x105 ** (
            -1) * x112 * 0.697149 + x111 * x208 * 0.46606 + x112 ** (-1) * x201 ** (-1) * (-242.356) + x108 * x112 ** (
                            -1) * 0.261032 + x201 ** (-1) * x209 * 58.4543 + x108 * x208 ** (
                            -1) * 0.30269 + x108 * x111 * (-0.183598) + x106 ** (-1) * x112 ** (
                            -1) * 12.3259 + x106 ** (-1) * x111 ** (-1) * (-13.7248)
        x307EqualsTwo = -4.40144 + x102 ** (-1) * x110 ** (-1) * (-3.4971) + x112 * x202 * (-0.0306613) + x103 ** (
            -1) * x204 * (-43.0255) + x111 * x205 * 0.155946 + x110 * x208 * 0.0941545 + x203 * x206 ** (
                            -1) * 0.386844 + x203 ** (-1) * x206 * 12.2186 + x101 * x204 * 0.00132263 + x101 ** (
                            -1) * x103 ** (-1) * 6595.83 + x202 * x208 * 0.0178928
        x308EqualsTwo = 0.756968 + x103 ** (-1) * x205 ** (-1) * (-645.415) + x101 ** (
            -1) * x109 * 7.78827 + x103 * x206 * (-0.000590993) + x109 * x204 * (-0.0105553) + x101 * x103 ** (-1) * (
                            -0.507904) + x103 ** (-1) * x203 * 21.8255 + x203 ** (-1) * x205 ** (
                            -1) * 19.0435 + x109 * x205 * (-0.0813564) + x104 ** (
                            -1) * x109 * 1.49701 + x101 * x208 * 0.000912961
        x309EqualsTwo = 1.28185 + x102 * x206 * 0.0191846 + x204 * x207 * 0.0272657 + x101 * x207 ** (-1) * (
            -0.00709976) + x101 ** (-1) * x204 ** (-1) * (-60.0672) + x104 ** (-1) * x106 * (
                            -0.0216769) + x108 * x205 * 0.07052 + x105 * x108 * (-0.00645342) + x108 * x204 * (
                            -0.023769) + x108 * x207 ** (-1) * 0.123772 + x104 * x105 ** (-1) * (-0.24784)
        x301 = 1 if (round(x301EqualsTwo) == 0) else 2
        x302 = 1 if (round(x302EqualsTwo) == 0) else 2
        x303 = 1 if (round(x303EqualsTwo) == 0) else 2
        x304 = 1 if (round(x304EqualsTwo) == 0) else 2
        x305 = 1 if (round(x305EqualsTwo) == 0) else 2
        x306 = 1 if (round(x306EqualsTwo) == 0) else 2
        x307 = 1 if (round(x307EqualsTwo) == 0) else 2
        x308 = 1 if (round(x308EqualsTwo) == 0) else 2
        x309 = 1 if (round(x309EqualsTwo) == 0) else 2
        cList = [x301, x302, x303, x304, x305, x306, x307, x308, x309]
        criterionList.append(cList)
    return criterionList


def calculatePerfectValue(xList, coeffList):
    x101 = xList[0]
    x102 = xList[1]
    x103 = xList[2]
    x104 = xList[3]
    x105 = xList[4]
    x106 = xList[5]
    x107 = xList[6]
    x108 = xList[7]
    x109 = xList[8]
    x110 = xList[9]
    x111 = xList[10]
    x112 = xList[11]
    x303EqualsTwo = 0.369661 + x106*x111*0.00310719 + x106*x108*(-0.000751507) + x103*x106*(-1.03015e-05) + x103*x108*4.53861e-05 + x111*(-0.357763) + x106*x112*0.00105434 + x102*x112*(-0.00670676) + x102*x108*0.00417287 + x103*0.000583292 + x102*x106*(-8.76937e-05)
    x304EqualsTwo = 0.175478 + x110*x112*(-0.154013) + x101*x111*0.0055126 + x103*x107*0.000703851 + x107*x109*(-0.0270747) + x103*x108*(-0.00028867) + x102*x110*0.0515488 + x107*x112*(-0.413692) + x108*x112*0.0185017 + x108*x109*0.00789789 + x101*x110*(-0.00487274) + x102*x111*(-0.0490524) + x101*x108*(-0.000395743) + x101*x107*0.000153086 + x107*0.920759 + x105*x107*(-0.0243143) + x105*x112*0.0514067 + x105*(-0.0825905) + x105*x108*0.00620842
    x305EqualsTwo = -0.227066 + x105*x111*(-0.0734265) + x107*x108*(-0.028469) + x103*x107*0.000299704 + x101*x104*0.000299719 + x104*x108*(-0.0224514) + x111*x112*0.358285 + x104*x106*0.000163868 + x103*x106*(-9.55294e-06) + x103*x108*0.0002392 + x105*x106*(-0.000231602) + x108*0.512628 + x108*x112*(-0.0751962) + x105*x110*0.0754866 + x101*x107*(-0.001482) + x102*x108*(-0.0126606) + x106*x108*0.000532562 + x102*x104*0.00464377 + x102*x110*(-0.0334515) + x105*x108*0.00934543 + x105*x112*(-0.0342288) + x101*x102*0.000261614 + x101*x110*(-0.00219381) + x107*x112*0.109794
    x306EqualsTwo = -0.0114987 + x108*x109*(-0.00578912) + x104**(-1)*x109**(-1)*1.1257 + x109**(-1)*x112**(-1)*(-0.0419663) + x106*x111**(-1)*(-0.00358674) + x106*x109*(-0.000515749) + x109*x110*0.0632775 + x109*x111*(-0.0298963) + x108*x109**(-1)*0.0109361 + x109**(-1)*x112*(-0.0432296) + x102*x109*0.00138459 + x103**(-1)*x109**(-1)*(-5.55096) + x106**(-1)*x108*0.88429 + x110*x111**(-1)*0.261843 + x106*x108*0.000715337 + x108*x110*(-0.0391553) + x103**(-1)*x108*2.59644 + x106*x107**(-1)*0.000557014 + x107*x110**(-1)*0.341142 + x105*x110**(-1)*(-0.00959482) + x107*x111**(-1)*(-0.0715939) + x106**(-1)*x109*(-0.78666) + x103**(-1)*x106**(-1)*(-656.336) + x106*x110**(-1)*(-0.00633399) + x104**(-1)*x106*0.0286779 + x104**(-1)*x107*(-0.886387) + x107*x109*0.0132561 + x105*x109*(-0.00200309) + x107*x110*(-0.0264503)
    x307EqualsTwo = 2.6937 + x101*x110*0.00637564 + x101*x109*(-0.00117356) + x109**2*(-0.00267333) + x105*x111*0.00413604 + x103*x112*(-0.00073236) + x109*0.204242 + x103*x106*1.62601e-05 + x106**2*(-1.08259e-05) + x102*x112*0.153545 + x101*x102*(-0.000396763) + x109*x112*(-0.104191) + x103*0.00284761 + x102*x103*(-0.000144981) + x106*x107*0.00251191 + x103*x110*(-0.000936957) + x101*x105*(-0.000577864) + x104*x105*0.00385265 + x112**2*(-0.83391) + x102*(-0.307295) + x102**2*0.00483699 + x107*(-0.112072) + x104*x110*(-0.0459923) + x101*x104*0.000413922 + x110*x112*0.216481 + x104*x109*0.0068067 + x102*x108*(-0.00353053) + x106*(-0.00962964) + x105*x106*0.000303744 + x107**2*(-0.0391921)
    x308EqualsTwo = -1.14363 + x102*x109*0.00138057 + x103*x106*1.10351e-05 + x105*x111*0.122882 + x106*x108*(-0.0012283) + x108*x109*(-0.0121911) + x110**2*0.44975 + x101*x107*0.00167406 + x106*x111*0.00572702 + x103*0.00782358 + x103**2*(-5.48141e-06) + x103*x107*(-0.000982276) + x101**2*(-2.41892e-05) + x103*x108*0.000759317 + x101*x110*0.00210718 + x105*x108*(-0.01283) + x107*x108*0.0327821 + x103*x105*(-0.00028816) + x110*x111*(-0.862231) + x108**2*0.00717402 + x103*x109*0.000164123 + x108*x111*(-0.134656) + x109*x112*(-0.0522137) + x109*0.141487 + x104*x108*0.0154947 + x104*x105*(-0.00406125) + x106*(-0.0119813) + x101*x106*1.94922e-05 + x106*x109*(-0.00031123) + x101*x105*(-0.000104463)
    x309EqualsTwo = 1.67402 + x103**(-1)*x111*64.7561 + x108*x109*(-0.00257077) + x103*x109**(-1)*0.000177662 + x101**(-1)*x102**(-1)*(-892.92) + x108*x109**(-1)*(-0.0215984) + x105*x109*0.00529672 + x107*x109*(-0.0818487) + x106**(-1)*x107**(-1)*8.77323 + x103**(-1)*x106*(-1.63549) + x101*x103*(-1.69885e-05) + x105**(-1)*x110**(-1)*(-4.57522) + x106**(-1)*x108*2.06638 + x104*x109**(-1)*0.00764918 + x107**(-1)*x112**(-1)*(-1.33627) + x107**(-1)*x111**(-1)*0.163089 + x109*x112**(-1)*(-0.250843) + x102**(-1)*x109*2.04587 + x110*x111**(-1)*0.144078 + x102*x112**(-1)*0.0875985 + x102**(-1)*x112*4.40152 + x101*x105*(-0.000362291) + x102**(-1)*x106**(-1)*(-267.832) + x101*x106*3.30086e-05 + x102*x110*(-0.0331608) + x107**(-1)*x110*0.687005 + x104*x105**(-1)*(-0.523747) + x104**(-1)*x107**(-1)*(-8.04198) + x101*x107*0.000894778 + x101**(-1)*x107**(-1)*26.1572
    x301 = 1
    x302 = 1
    x303 = 1 if (round(x303EqualsTwo) == 0) else 2
    x304 = 1 if (round(x304EqualsTwo) == 0) else 2
    x305 = 1 if (round(x305EqualsTwo) == 0) else 2
    x306 = 1 if (round(x306EqualsTwo) == 0) else 2
    x307 = 1 if (round(x307EqualsTwo) == 0) else 2
    x308 = 1 if (round(x308EqualsTwo) == 0) else 2
    x309 = 1 if (round(x309EqualsTwo) == 0) else 2
    cList = [x301, x302, x303, x304, x305, x306, x307, x308, x309]
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
        x201 = randint(1, 10000) / 100
        x202 = randint(1, 25000) / 100
        x203 = randint(5, 60)
        x204 = randint(1, 5)
        x205 = randint(1, 2)
        x206 = randint(1, 2)
        x207 = randint(1, 2)
        x208 = randint(1, 2)
        x209 = randint(1, 2)
        uList = [x201, x202, x203, x204, x205, x206, x207, x208, x209]
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
        x201 = randint(1, 10000) / 100
        x202 = randint(1, 25000) / 100
        x203 = randint(5, 60)
        x204 = randint(1, 5)
        x205 = randint(1, 2)
        x206 = randint(1, 2)
        x207 = randint(1, 2)
        x208 = randint(1, 2)
        x209 = randint(1, 2)
        uList = [x201, x202, x203, x204, x205, x206, x207, x208, x209]
        solList[i] = copy.deepcopy(uList)
        i += 1
    return solList


def calculateTreatment(xList):
    coeffList = saatiMethod()
    perfectValue = calculatePerfectValue(xList, coeffList)
    treatmentList = []
    GeneticRaceplicationList = []
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
                    GeneticRaceplicationList.append(criterionList[i])
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
                        GeneticRaceplicationList.append(criterionList[fatherList[0]])
                        break
                    motherList = getMothers(fatherList, probList)
                    tempSolList = copy.deepcopy(solList)
                    newSolList = crossover(solList, tempSolList, fatherList, motherList)
                    solList = copy.deepcopy(newSolList)
    with open('D:\\JavaProjects\\Babenko\\Files\\currentResult.txt', 'w') as f:
        for i in range(5):
            for item in treatmentList[i]:
                f.write("%s\n" % item)
        for item in GeneticRaceplicationList[0]:
            f.write("%s\n" % item)
    f.close()


file = open("D:\\JavaProjects\\Babenko\\Files\\currentInput.txt", "r")
strLine = file.readline()
strList = strLine.split(' ')
xList = []
for strValue in strList:
    xList.append(float(strValue))
calculateTreatment(xList)
