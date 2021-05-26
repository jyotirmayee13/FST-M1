import pytest

def testAdd():
    num1=10
    num2=15
    assert num1+num2==25

def testsubtract():
    num1=15
    num2=10
    assert num1-num2==5
@pytest.mark.mul
def test_mul():
    num1=10
    num2=15
    assert num1*num2==150
@pytest.mark.div
def test_div():
    num1=10
    num2=15
    assert num2//num1==1