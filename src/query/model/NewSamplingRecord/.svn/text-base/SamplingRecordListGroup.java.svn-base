package query.model.NewSamplingRecord;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;


public class SamplingRecordListGroup extends AbstractModelObject {

	private List<SamplingRecordList> samplingRecordLists = new ArrayList<SamplingRecordList>();

	public List<SamplingRecordList> getSamplingRecordLists() {
		return samplingRecordLists;
	}

	public SamplingRecordListGroup() {
	}
	
	public void addSamplingRecordList(SamplingRecordList samplingRecordList) {
		List<SamplingRecordList> oldValue = samplingRecordLists;
		samplingRecordLists = new ArrayList<SamplingRecordList>(samplingRecordLists);
		samplingRecordLists.add(samplingRecordList);

		firePropertyChange("samplingRecordLists", oldValue, samplingRecordLists);
	}
	
	public void removeISamplingRecordList(SamplingRecordList samplingRecordList) {
		samplingRecordLists.remove(samplingRecordList);
	}
	
	public void removeAll() {
		List<SamplingRecordList> oldValue = samplingRecordLists;
		samplingRecordLists = new ArrayList<SamplingRecordList>(samplingRecordLists);
		samplingRecordLists.clear();
		firePropertyChange("samplingRecordLists", oldValue, samplingRecordLists);
	}
	
}
