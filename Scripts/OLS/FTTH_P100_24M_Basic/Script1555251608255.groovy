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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://dev.time.com.my/')

// Get Test Scenario from data source
def lTestScenario = 'OLS_'+findTestData('DataSource').getValue(1, 1)

WebUI.click(findTestObject('OLS/FTTH/a_Personal'))

WebUI.click(findTestObject('OLS/FTTH/a_SIGN UP NOW'))

// Begin -Have we got you covered
WebUI.setText(findTestObject('OLS/FTTH/input_Have we got you covered_rfs'), findTestData('DataSource').getValue(2, 1))

WebUI.click(findTestObject('OLS/FTTH/li_Building_name'))

WebUI.setText(findTestObject('OLS/FTTH/input_Block_block'), 'A')

WebUI.setText(findTestObject('OLS/FTTH/input_Level_level'), '200')

WebUI.setText(findTestObject('OLS/FTTH/input_Unit_unit_no', [('variable') : findTestData('DataSource').getValue(2, 1)]), findTestData(
	'DataSource').getValue(3, 1))

WebUI.click(findTestObject('OLS/FTTH/input_Property Ownership_property_type'))

// Print page - 'Have_we_got_you_covered'
lpagename = 'Have_we_got_you_covered'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_next'), 10)

WebUI.click(findTestObject('OLS/FTTH/button_next'))

WebUI.delay(5)

// Begin - Need a little something extra
WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_next'), 10)

// Print page - 'Need_a_little_something_extra'
lpagename = 'Need_a_little_something_extra'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_next'))

// End - Need a little something extra
// Begin - Personal details
WebUI.setText(findTestObject('OLS/FTTH/input_Full Name (as per MyKadPassport)_fullname'), findTestData('DataSource').getValue(
        4, 1))

WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_-Select-                                                            MaleFemale'), 
    'male', true)

WebUI.setText(findTestObject('OLS/FTTH/input_MyKad Number_ic1'), findTestData('DataSource').getValue(5, 1))

WebUI.setText(findTestObject('OLS/FTTH/input_-_ic2'), findTestData('DataSource').getValue(6, 1))

WebUI.setText(findTestObject('OLS/FTTH/input_-_ic3'), findTestData('DataSource').getValue(7, 1))

WebUI.setText(findTestObject('OLS/FTTH/input_Email Address_email'), findTestData('DataSource').getValue(8, 1))

WebUI.setText(findTestObject('OLS/FTTH/input_-_phone'), '01234567')

WebUI.click(findTestObject('OLS/FTTH/label_I have read understood and agree to be bound by the Terms and Conditions of TIME Fibre Home Broadband which accompany the subscription of the product(s) andor service(s).'))

WebUI.click(findTestObject('OLS/FTTH/label_I hereby consent to the collection use and disclosure of my personal information in accordance with the Privacy Policy.'))

WebUI.click(findTestObject('OLS/FTTH/label_I hereby declare that all of the information and document(s) provided are true and valid.'))

// Print page - 'Personal_details'
lpagename = 'Personal_details'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_next'))

// End - Personal details
// Begin - Billing address
//Payment method - AUto debit
WebUI.callTestCase(findTestCase('OLS/Auto_debit'), [:], FailureHandling.STOP_ON_FAILURE)

// Begin Upload document
WebUI.click(findTestObject('OLS/FTTH/button_Select File'))

WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OLS/FTTH/img_ic_front'), 30)

WebUI.click(findTestObject('OLS/FTTH/button_Select File_1'))

WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OLS/FTTH/img_ic_back'), 50)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_preview'), 30)

WebUI.scrollToElement(findTestObject('OLS/FTTH/button_preview'), 0)

WebUI.mouseOver(findTestObject('OLS/FTTH/button_preview'))

WebUI.doubleClick(findTestObject('OLS/FTTH/button_preview'))

// Print page - 'Billing_address'
lpagename = 'Billing_address'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_preview'))

// End Upload document
// End - Billing address
//Begin OTC assertion
// get OTC actual result from OLS
actual_otc = WebUI.getText(findTestObject('OLS/FTTH/FTTH_P100_24M_Basic_Total_OTC'))

println('*******actual_otc******' + actual_otc)

// get OTC expected result from DataSource
expected_otc = findTestData('DataSource').getValue(14, 1)

println('*******expected_otc******' + expected_otc)

// Assertion - OTC
if (actual_otc == expected_otc) {
    assert true
} else {
    assert false
}

//End OTC assertion
//Begin MRC assertion
// get MRC actual result from OLS
actual_MRC = WebUI.getText(findTestObject('OLS/FTTH/FTTH_P100_24M_Basic_Total_MRC'))

println('*******actual_MRC******' + actual_MRC)

// get MRC expected result from DataSource
expected_MRC = findTestData('DataSource').getValue(13, 1)

println('*******expected_MRC******' + expected_MRC)

// Assertion - MRC
if (actual_MRC == expected_MRC) {
    assert true
} else {
    assert false
}

//End MRC assertion
// Print page - 'Preview'
lpagename = 'Preview'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_next_1'))

WebUI.click(findTestObject('OLS/FTTH/label_I agree to make a payment in accordance with the Terms  Conditions.'))

WebUI.click(findTestObject('OLS/FTTH/button_Next (1)'))

WebUI.callTestCase(findTestCase('common/ACS_Emulator'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_Proceed'), 10)

// Print page - 'which Page'
lpagename = 'which_page'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_Proceed'), 15)

WebUI.click(findTestObject('OLS/FTTH/button_Proceed'))

WebUI.delay(10)

//Begin Apppoinment calender
thisDay = findTestData('DataSource').getValue(9, 1)

calenderDay = ('OLS/CALENDER/a_' + thisDay)


for (def count : (0..2)){
	
	WebUI.selectOptionByIndex(findTestObject('OLS/CALENDER/select_Month'), count)
	
	if( WebUI.waitForElementClickable(findTestObject(calenderDay), 10) == true){

		WebUI.scrollToElement(findTestObject(calenderDay), 0)
		
		WebUI.mouseOver(findTestObject(calenderDay))
		
		WebUI.doubleClick(findTestObject(calenderDay))
		
		break
	}
}

/**
WebUI.waitForElementClickable(findTestObject(calenderDay), 8)

// if date is not avilable, select next month
if (WebUI.waitForElementClickable(findTestObject(calenderDay), 8) == false) {
    WebUI.selectOptionByIndex(findTestObject('OLS/CALENDER/select_Month'), 1)
}

WebUI.waitForElementClickable(findTestObject(calenderDay), 13)

WebUI.scrollToElement(findTestObject(calenderDay), 0)

WebUI.mouseOver(findTestObject(calenderDay))

WebUI.doubleClick(findTestObject(calenderDay))
**/

WebUI.delay(10)

WebUI.selectOptionByIndex(findTestObject('OLS/FTTH/select_Please select sessionMorning (1000AM)Afternoon (230PM)'), 1)

// Print page - 'Calender'
lpagename = 'Calender'

WebUI.callTestCase(findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_proceed (1)'))

//End Apppoinment calender
WebUI.click(findTestObject('OLS/FTTH/button_Yes'))

WebUI.closeBrowser()

