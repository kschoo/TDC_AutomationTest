import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.delay(15)

//WebUI.waitForElementClickable(findTestObject('OLS/CALENDER/select_Month'),20)

WebUI.selectOptionByValue(findTestObject('OLS/CALENDER/select_Month'),findTestData('DataSource').getValue(11, 2), true)

thisDay = findTestData('DataSource').getValue(9, 1)

calenderDay = ('CALENDER/a_' + thisDay)

println('*****Calender Day****' + calenderDay)

WebUI.waitForElementClickable(WebUI.click(findTestObject(calenderDay)), 40)

WebUI.scrollToElement(findTestObject('FTTH/calenderDay'), 0)

WebUI.mouseOver(findTestObject('FTTH/calenderDay'))

WebUI.click(findTestObject(calenderDay))

println('*****Appointmen time****' + findTestData('DataSource').getValue(10, 1))

WebUI.delay(15)

WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_Please select sessionMorning (1000AM)Afternoon (230PM)'), findTestData(
		'DataSource').getValue(10, 1), true)

WebUI.click(findTestObject('OLS/FTTH/button_proceed (1)'))