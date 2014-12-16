package cmap.services;

import java.util.Set;

import cmap.model.AssignVM;

public interface AssignService {
	// --- Lấy Assign theo id
	public AssignVM findById(int id);
	
	// --- Lấy danh sách Assign của user theo user_id
	public Set<AssignVM> getList(String username);
	
	// --- Thêm Assign
	public AssignVM add(AssignVM assign);
	
	// --- Xóa assign
	public boolean delete(int assign_id);
	
	// --- Giao assign cho user
	public boolean postUser(int assign_id, String username);
}
