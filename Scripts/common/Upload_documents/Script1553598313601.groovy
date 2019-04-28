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

WebUI.delay(2)

uploadDummyDoc()

WebUI.delay(5)

def uploadDummyDoc() {
    Runtime runtime = Runtime.getRuntime()

    //set your path of the file upload exe here
	def exeFile = GlobalVariable.path+'\\Include\\scripts\\uploadFile\\uploadDummyDoc.exe'
	
	//set your path of the file to be uploaded here
	def testFile = GlobalVariable.path+'\\Include\\scripts\\uploadFile\\logo.png'

	println('***************exe path:'+exeFile)
	println('***************test path:'+testFile)
	Process process = runtime.exec(exeFile+' '+testFile)


}

