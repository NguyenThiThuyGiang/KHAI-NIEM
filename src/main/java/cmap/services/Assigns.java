package cmap.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmap.entity.Assign;
import cmap.entity.FeedBack;
import cmap.entity.Member;
import cmap.model.AssignVM;
import cmap.repositories.MemberRepository;

@Service
public class Assigns implements AssignService {

	@Autowired
	private MemberRepository mems;

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public AssignVM findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AssignVM> getList(String username) {
		log.info("------------------ Lấy danh sách assign của " + username + " --------------");
		// --- Tìm user trùng id
		Member mem = mems.findByUsername(username);
		// --- Nếu không tồn tại member nào 
		if(mem == null)
			return null;
		// --- Khởi tạo một list AssignVM rỗng
		Set<AssignVM> list = new HashSet<AssignVM>(0);
		// --- Duyệt danh sách bài tập của member trên
		for(Assign a : mem.getAssigns()){
			// ---- Trả về feedback ứng với member trong danh sách
			FeedBack feed = findByUser(mem.getId(), a.getFeedbacks());
			// --- Tạo một AssignVM mới tham chiếu Assign
			AssignVM assign = new AssignVM(a.getId(), a.getTopic(), 
					a.getDeadline(), a.getInfo(), a.getCmap().getAuthor().getId(), 
					a.getCmap().getAuthor().getFullname(), 
					(feed != null) ? feed.getScore() : -1,
					feed != null ? feed.getDate_create() : new Date(), 
					a.getFeedbacks().size(), a.getCmap().getConcepts().size());
			// --- Thêm vào list
			list.add(assign);
		}
		
		return list;
	}
	
	public FeedBack findByUser(int mem_id, Set<FeedBack> feeds) {
		// --- Duyệt danh sách feeds, trả về feed có mem_id trùng mới nhất
		for (FeedBack feed : feeds) {
			if (feed.getCmap().getAuthor().getId() == mem_id)
				return feed;
		}
		return null;
	}
	@Override
	public AssignVM add(AssignVM assign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int assign_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postUser(int assign_id, String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
