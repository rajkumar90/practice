package rippling;

import java.util.concurrent.Callable;

public class Job implements Callable<Integer> {
	TaskToExecute task;
	String jobId;
	
	@Override
	public Integer call() throws Exception {
		String status = getStatus(jobId);
		Integer jobCompletionStatus = 0;
		
		if (status.equals("NEW") || status.equals("READY_TO_RETRY")) {
			updateJobStatus(jobId, "IN_PROGRESS");
			// 
			jobCompletionStatus = task.execute();
			// SUCCESS
			if (jobCompletionStatus == 0)
				updateJobStatus(jobId, "SUCCESS");
			else if (jobCompletionStatus == 1) {
				updateJobStatus(jobId, "READY_TO_RETRY");
				// Enqueue again
			}
		}
		return jobCompletionStatus;
		
	}

	private void updateJobStatus(String jobId2, String string) {
		// TODO Auto-generated method stub
		
	}

	public String getStatus(String jobId) {
		// Get job status from datastore
		return "";
	}
}
