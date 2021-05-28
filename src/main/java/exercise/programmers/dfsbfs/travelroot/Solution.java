package exercise.programmers.dfsbfs.travelroot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Ticket {
    private String departure;
    private String arrival;
    private boolean visited;
    private List<Ticket> availables;

    Ticket(String[] ticket) {
        this.departure = ticket[0];
        this.arrival = ticket[1];
        availables = new LinkedList<>();
    }

    //티켓으로 갈 수 있는 도시를 리스트에 저장
    void addAvailables(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            if (this.arrival.equals(ticket.departure)) {
                availables.add(ticket);
            }
        }
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Ticket> getAvailables() {
        return availables;
    }

    public void setAvailables(List<Ticket> availables) {
        this.availables = availables;
    }
}

class Route {
    private List<Ticket> ticketList;
    private List<Ticket> route;
    private List<Ticket> tmpRoute;

    Route(String[][] tickets) {
        ticketList = new ArrayList<>();
        for (String[] ticket : tickets) {
            ticketList.add(new Ticket(ticket));
        }
        route = new ArrayList<>();
        tmpRoute = new ArrayList<>();
        setAvailables();
    }

    //각 티켓들 마다 갈 수있는 경로들을 세팅
    void setAvailables() {
        for (Ticket ticket : ticketList) {
            ticket.addAvailables(ticketList);
        }
    }

    void findRoute(Ticket ticket, int step) {
        if (ticket.isVisited()) {
            return;
        }
        if (step == 1 && !ticket.getDeparture().equals("ICN")) {
            return;
        }
        if (tmpRoute.size() >= step) {
            int compare = ticket.getDeparture().compareTo(tmpRoute.get(step-1).getDeparture());
            if (compare > 0) {
                return;
            } else if (compare == 0) {
                if (ticket.getArrival().compareTo(tmpRoute.get(step-1).getArrival()) > 0) {
                    return;
                }
            }
        }



        tmpRoute.add(ticket);
        ticket.setVisited(true);
        if (step == ticketList.size()) {
            if (route.size() == 0) {
                route.addAll(tmpRoute);
                tmpRoute.remove(ticket);
                ticket.setVisited(false);
                return;
            }
            else {
                for (int i = 0; i < ticketList.size(); i++) {
                    if (!tmpRoute.get(i).getDeparture().equals("ICN")) {
                        break;
                    }
                    int compare = tmpRoute.get(i).getDeparture().compareTo(route.get(i).getDeparture());
                    if (compare < 0) {
                        route.clear();
                        route.addAll(tmpRoute);
                        break;
                    } else if (compare == 0) {
                        if (tmpRoute.get(i).getArrival().compareTo(route.get(i).getArrival()) < 0) {
                            route.clear();
                            route.addAll(tmpRoute);

                            break;
                        }
                    }
                }
            }
            ticket.setVisited(false);
            tmpRoute.remove(ticket);
            return;
        }

        for (Ticket availableTicket : ticket.getAvailables()) {
            findRoute(availableTicket, step + 1);
        }
        tmpRoute.remove(ticket);
        ticket.setVisited(false);
    }

    void findRoute() {
        for (Ticket ticket : ticketList) {
            if (ticket.getDeparture().equals("ICN")) {
                findRoute(ticket, 1);
            }
        }
    }

    String[] convertListToArray() {
        String[] answer = null;
        answer = new String[route.size() + 1];
        for (int i = 0; i < answer.length-1; i++) {
            answer[i] = route.get(i).getDeparture();
        }
        answer[route.size()] = route.get(route.size() - 1).getArrival();
        return answer;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Ticket> getRoute() {
        return route;
    }

    public void setRoute(List<Ticket> route) {
        this.route = route;
    }

    public List<Ticket> getTmpRoute() {
        return tmpRoute;
    }

    public void setTmpRoute(List<Ticket> tmpRoute) {
        this.tmpRoute = tmpRoute;
    }
}

class Solution {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO" }, {"ICN", "ATL" }, {"SFO", "ATL" }, {"ATL", "ICN" }, {"ATL", "SFO" }};
        Solution s = new Solution();
        for (String str : s.solution(tickets)) {
            System.out.println(str);
        }
    }

    public String[] solution(String[][] tickets) {
        Route route = new Route(tickets);
        route.findRoute();
        return route.convertListToArray();
    }
}
