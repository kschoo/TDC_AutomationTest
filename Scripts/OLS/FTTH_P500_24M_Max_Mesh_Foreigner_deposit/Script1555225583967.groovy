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
def lTestScenario = 'OLS_'+findTestData('DataSource').getValue(1, 6)

WebUI.click(findTestObject('OLS/FTTH/a_Personal'))

WebUI.click(findTestObject('OLS/FTTH/a_SIGN UP NOW_P500'))

//Begin - Have_we_got_you_covered
WebUI.setText(findTestObject('OLS/FTTH/input_Have we got you covered_rfs'), findTestData('DataSource').getValue(2, 6))

WebUI.click(findTestObject('OLS/FTTH/li_Building_name'))

WebUI.setText(findTestObject('OLS/FTTH/input_Block_block'), 'A')

WebUI.setText(findTestObject('OLS/FTTH/input_Level_level'), '200')

WebUI.setText(findTestObject('OLS/FTTH/input_Unit_unit_no'), findTestData('DataSource').getValue(3, 6))

WebUI.click(findTestObject('OLS/FTTH/input_Property Ownership_property_type'))

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_next'), 10)

// Print page - 'Have_we_got_you_covered'
lpagename = 'Have_we_got_you_covered'

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('OLS/FTTH/button_next'))

WebUI.delay(5)

//End - Have_we_got_you_covered

// Begin - Need a little something extra
WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_Lite                                                     Max'), 'home_max', 
    true)

WebUI.click(findTestObject('OLS/FTTH/button_ADD'))

WebUI.click(findTestObject('OLS/FTTH/button_ADD_1'))

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_next'), 10)

WebUI.click(findTestObject('OLS/FTTH/button_next'))

// Print page - 'Need_a_little_something_extra'
lpagename = 'Need_a_little_something_extra'

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)


// End - Need a little something extra


//Begin - Personal details
WebUI.setText(findTestObject('OLS/FTTH/input_Full Name (as per MyKadPassport)_fullname'), findTestData('DataSource').getValue(4, 6))

WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_-Select-                                                            MaleFemale'), 
    'male', true)

WebUI.selectOptionByIndex(findTestObject('OLS/Foreigner_deposit/select_MalaysianNon-Malaysian'), 1)

WebUI.verifyElementPresent(findTestObject('OLS/Foreigner_deposit/label_A RM300 deposit applies for non-Malaysians.'), 3)

WebUI.setText(findTestObject('OLS/Foreigner_deposit/input_Passport Number_passport'), findTestData('DataSource').getValue(5, 6))

WebUI.setText(findTestObject('OLS/FTTH/input_Email Address_email'), findTestData('DataSource').getValue(8, 6))

WebUI.setText(findTestObject('OLS/FTTH/input_-_phone'), '012345678')

WebUI.click(findTestObject('OLS/FTTH/label_I have read understood and agree to be bound by the Terms and Conditions of TIME Fibre Home Broadband which accompany the subscription of the product(s) andor service(s).'))

WebUI.click(findTestObject('OLS/FTTH/label_I hereby consent to the collection use and disclosure of my personal information in accordance with the Privacy Policy.'))

WebUI.click(findTestObject('OLS/FTTH/label_I hereby declare that all of the information and document(s) provided are true and valid.'))

// Print page - 'Personal_details'
lpagename = 'Personal_details'

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_next'))

//End - Personal details


// Begin - Billing address
//Payment method - AUto debit
WebUI.callTestCase(findTestCase('OLS/Auto_debit'), [:], FailureHandling.STOP_ON_FAILURE)

// Begin Upload document
WebUI.click(findTestObject('OLS/Foreigner_deposit/button_Select File'))

WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OLS/Foreigner_deposit/img_passport'), 30)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_preview'), 30)

WebUI.scrollToElement(findTestObject('OLS/FTTH/button_preview'), 0)

WebUI.mouseOver(findTestObject('OLS/FTTH/button_preview'))

WebUI.doubleClick(findTestObject('OLS/FTTH/button_preview'))

// Print page - 'Billing_address'
lpagename = 'Billing_address'

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_preview'))

// End Upload document


//Begin upfront payment assertion
// get  upfront payment actual result from OLS
WebUI.waitForElementPresent(findTestObject('OLS/Foreigner_deposit/FD_Upfront_payment'), 30)

actual_upFrontPaymnt = WebUI.getText(findTestObject('OLS/Foreigner_deposit/FD_Upfront_payment'))

println('*******actual_upFrontPaymnt******' + actual_upFrontPaymnt)

// get  upfront payment expected result from DataSource
expected_upFrontPaymnt = findTestData('DataSource').getValue(12, 6)

println('*******expected_uprontPaymnt******' + expected_upFrontPaymnt)

// Assertion -  upfront payment
if (actual_upFrontPaymnt == expected_upFrontPaymnt) {
    assert true
} else {
    assert false
}

//End OTC assertion
//Begin MRC assertion
// get MRC actual result from OLS
WebUI.waitForElementPresent(findTestObject('OLS/Foreigner_deposit/FD_MRC'), 30)

actual_MRC = WebUI.getText(findTestObject('OLS/Foreigner_deposit/FD_MRC'))

println('*******actual_MRC******' + actual_MRC)

// get MRC expected result from DataSource
expected_MRC = findTestData('DataSource').getValue(13, 6)

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

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.waitForElementClickable(findTestObject('OLS/FTTH/button_next_1'), 10)

//End upfront payment assertion
WebUI.click(findTestObject('OLS/FTTH/button_next_1'))

WebUI.callTestCase(findTestCase('OLS/Proceed_with_payment'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('common/Payment_gateway'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('common/ACS_Emulator'), [:], FailureHandling.STOP_ON_FAILURE)

//Begin Apppoinment calender
thisDay = findTestData('DataSource').getValue(9, 6)

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

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OLS/FTTH/button_proceed (1)'))

//End Apppoinment calender

//Appointment confimation
WebUI.click(findTestObject('OLS/FTTH/button_Yes'))

WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

