package graph;

import models.Course;
import java.util.*;

public class PrerequisiteGraph {
    // 邻接表：courseId -> 它的所有prerequisite
    private Map<String, List<String>> graph;
    
    public PrerequisiteGraph() {
        this.graph = new HashMap<>();
    }
    
    // 添加课程和它的prerequisites
    public void addCourse(Course course) {
        graph.put(course.getCourseId(), course.getPrerequisites());
    }
    
    // 检查是否可以选这门课
    public boolean canTake(String courseId, Set<String> completedCourses) {
        List<String> prereqs = graph.get(courseId);
        
        if (prereqs == null || prereqs.isEmpty()) {
            return true; // 没有prerequisite
        }
        
        // 所有prerequisite都修完了才能选
        return completedCourses.containsAll(prereqs);
    }
    
    // 获取当前可选的所有课程
    public List<String> getAvailableCourses(Set<String> completedCourses, 
                                           List<Course> allCourses) {
        List<String> available = new ArrayList<>();
        
        for (Course course : allCourses) {
            String courseId = course.getCourseId();
            
            // 没修过 且 prerequisite满足
            if (!completedCourses.contains(courseId) && 
                canTake(courseId, completedCourses)) {
                available.add(courseId);
            }
        }
        
        return available;
    }
    
    // 拓扑排序：返回合理的课程顺序
    public List<String> topologicalSort() {
        // TODO: 你来实现！（BFS或DFS）
        // 这个可以用来检测是否有循环依赖
        return new ArrayList<>();
    }
}
