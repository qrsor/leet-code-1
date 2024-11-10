package pl.qrsor.neetcode.carfleet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


class Solution
{
	record Car(int position, double arrivalTime) {}

	public int carFleet(int target, int[] position, int[] speed)
	{
		var carList = sortCarsByPosition(position, speed, target);
		var stack = new Stack<Car>();

		stack.add(carList.getFirst());

		for (int i = 1; i < carList.size(); i++)
		{
			var currentCar = carList.get(i);
			var furthestCar = stack.peek();

			if(currentCar.arrivalTime > furthestCar.arrivalTime) {
				stack.add(currentCar);
			}
		}

		return stack.size();
	}

	private List<Car> sortCarsByPosition(int[] position, int[] speed, int target)
	{
		var result = new ArrayList<Car>(position.length);

		for(int i=0;i<position.length;i++) {
			int currentPosition = position[i];
			double arrivalTime = (double) (target - currentPosition) / speed[i];
			result.add(new Car(currentPosition, arrivalTime));
		}

		result.sort(Comparator.comparing(Car::position).reversed());

		return result;
	}
}
