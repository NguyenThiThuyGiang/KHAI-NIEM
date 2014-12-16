package cmap.services;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import cmap.entity.Assign;
import cmap.entity.CMap;
import cmap.entity.FeedBack;
import cmap.entity.Relation;
import cmap.repositories.AssignRepository;
import cmap.repositories.CMapRepository;

public class FeedBacks {

	// --- Tự động liên kết các đối tượng
	@Autowired
	CMapRepository cmaps;
	
	@Autowired
	AssignRepository assigns;
	
	public void compair(int cmap_id, int assign_id){
		// --- Tìm cmap theo id
		CMap cmap = cmaps.findById(cmap_id);
		
		// --- Tìm assign theo id
		Assign assign = assigns.findById(assign_id);
		
		// --- Nếu 1 trong 2 cái không tồn tại thì hủy
		if(cmap == null || assign == null)
			return;
		
		// --- Tạo mới một thực thể Feedback 
		FeedBack feed = new FeedBack(-1, new Date(), assign, cmap);
		
		// --- Bắt đầu quá trình chấm bài
		
		// --- Lây danh sách Relation của đáp án
		Set<Relation> relationKey = assign.getCmap().getRelations();
		// --- Lấy danh sách Realation của bài làm
		Set<Relation> relationList = cmap.getRelations() ;
	}
}
