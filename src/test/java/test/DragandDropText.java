package test;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.DragandDropmodule;

public class DragandDropText extends BaseTest {
      
	@Test(priority = 5,description = "Verify the functionality of drag and drop on the circles")
	public void validationonDragandDropText() throws Exception
	{
		DragandDropmodule ddm = new DragandDropmodule();
		ddm.getViewText();
	 	ddm.getDragandDrop();
       BaseTest.utils.DragandDrop();
       ddm.getDroppedElement();
	}
}
